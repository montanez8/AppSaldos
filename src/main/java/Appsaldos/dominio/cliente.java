package Appsaldos.dominio;

public class cliente {
    private int id_cliente;
    private String nombres;
    private  String apellidos;
    private  String email;
    private  String telefono;
    private double saldo;

    public cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public cliente(int id_cliente, String nombres, String apellidos, String email, String telefono, double saldo) {
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }
    public cliente( String nombres, String apellidos, String email, String telefono, double saldo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }


    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


}
