package Model;
public class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String rut;

    public Cliente(String nombre, String direccion, String telefono, String correo, String rut) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        if (validarCorreo(correo)) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }

        if (validarRut(rut)) {
            this.rut = rut;
        } else {
            throw new IllegalArgumentException("RUT no válido");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (validarCorreo(correo)) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (validarRut(rut)) {
            this.rut = rut;
        } else {
            throw new IllegalArgumentException("RUT no válido");
        }
    }

    private boolean validarCorreo(String correo) {
        return correo.contains("@");
    }

    private boolean validarRut(String rut) {
        rut = rut.replace("-", "").replace(".", "").toUpperCase();
        if (!rut.matches("\\d{1,8}-[Kk\\d]")) {
            return false;
        }
        char dvIngresado = rut.charAt(rut.length() - 1);
        int rutNumerico = Integer.parseInt(rut.substring(0, rut.length() - 2));
        int m = 0;
        int s = 1;
        while (rutNumerico > 0) {
            s = (s + rutNumerico % 10 * (9 - m++ % 6)) % 11;
            rutNumerico /= 10;
        }
        char dvEsperado = (char) (s != 0 ? s + '0' : 'K');
        return dvIngresado == dvEsperado;
    }
}