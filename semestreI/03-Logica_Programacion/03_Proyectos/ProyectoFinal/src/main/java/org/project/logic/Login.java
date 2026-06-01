package org.project.logic;


public class Login {
    public boolean autenticar(Usuario usuario, String usuarioSuministrado, String contrasenaSuministrada){
        if (usuario == null || contrasenaSuministrada == null || usuarioSuministrado == null) {
            return false;
        }

        return usuario.getNombre().equals(usuarioSuministrado) &&
                usuario.getContrasena().equals(contrasenaSuministrada);
    }
}
