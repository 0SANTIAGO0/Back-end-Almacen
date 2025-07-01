package pe.cibertec.proy_sistema_almacen.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pe.cibertec.proy_sistema_almacen.entity.Usuarios;
import pe.cibertec.proy_sistema_almacen.repository.UsuariosRepository;
import pe.cibertec.proy_sistema_almacen.service.JwtService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {


        String authHeader = request.getHeader("Authorization");
        String jwt = null;
        String correo = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            correo = jwtService.extractCorreo(jwt);
        }

        if (correo != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Optional<Usuarios> userOpt = usuariosRepository.findByCorreo(correo);
            if (userOpt.isPresent() && jwtService.isTokenValid(jwt, userOpt.get())) {
                Usuarios usuario = userOpt.get();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        usuario, null, List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()))
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}