package Gui;
import Model.Cliente;
import Model.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class AutomotoraGUI {
    private JFrame frame;
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;
    public AutomotoraGUI() {
        frame = new JFrame("Automotora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menú Principal");
        JMenuItem agregarClienteMenuItem = new JMenuItem("Agregar Cliente");
        JMenuItem agregarVehiculoMenuItem = new JMenuItem("Agregar Vehículo");
        JMenuItem buscarVehiculoMenuItem = new JMenuItem("Buscar Vehículos");
        agregarClienteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarCliente();
            }
        });
        agregarVehiculoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarVehiculo();
            }
        });
        buscarVehiculoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaBuscarVehiculos();
            }
        });
        menu.add(agregarClienteMenuItem);
        menu.add(agregarVehiculoMenuItem);
        menu.add(buscarVehiculoMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
    private void abrirVentanaAgregarCliente() {
        JFrame ventanaAgregarCliente = new JFrame("Agregar Cliente");
        ventanaAgregarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaAgregarCliente.setSize(300, 200);
        ventanaAgregarCliente.setLayout(new GridLayout(6, 2));
        JTextField nombreField = new JTextField();
        JTextField direccionField = new JTextField();
        JTextField telefonoField = new JTextField();
        JTextField correoField = new JTextField();
        JTextField rutField = new JTextField();
        JButton agregarButton = new JButton("Agregar Cliente");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String direccion = direccionField.getText();
                String telefono = telefonoField.getText();
                String correo = correoField.getText();
                String rut = rutField.getText();

                if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty() || rut.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        Cliente cliente = new Cliente(nombre, direccion, telefono, correo, rut);
                        clientes.add(cliente);
                        nombreField.setText("");
                        direccionField.setText("");
                        telefonoField.setText("");
                        correoField.setText("");
                        rutField.setText("");
                        JOptionPane.showMessageDialog(null, "Cliente agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, "Datos inválidos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        ventanaAgregarCliente.add(new JLabel("Nombre:"));
        ventanaAgregarCliente.add(nombreField);
        ventanaAgregarCliente.add(new JLabel("Dirección:"));
        ventanaAgregarCliente.add(direccionField);
        ventanaAgregarCliente.add(new JLabel("Teléfono:"));
        ventanaAgregarCliente.add(telefonoField);
        ventanaAgregarCliente.add(new JLabel("Correo:"));
        ventanaAgregarCliente.add(correoField);
        ventanaAgregarCliente.add(new JLabel("RUT:"));
        ventanaAgregarCliente.add(rutField);
        ventanaAgregarCliente.add(new JLabel());
        ventanaAgregarCliente.add(agregarButton);
        ventanaAgregarCliente.setVisible(true);
    }
    private void abrirVentanaAgregarVehiculo() {
        JFrame ventanaAgregarVehiculo = new JFrame("Agregar Vehículo");
        ventanaAgregarVehiculo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaAgregarVehiculo.setSize(300, 250);
        ventanaAgregarVehiculo.setLayout(new GridLayout(7, 2));
        JTextField nombreField = new JTextField();
        JTextField anioField = new JTextField();
        JTextField precioField = new JTextField();
        JTextField kilometrosField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField marcaField = new JTextField();
        JButton agregarButton = new JButton("Agregar Vehículo");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                int anio = Integer.parseInt(anioField.getText());
                double precio = Double.parseDouble(precioField.getText());
                double kilometros = Double.parseDouble(kilometrosField.getText());
                String color = colorField.getText();
                String marca = marcaField.getText();
                if (nombre.isEmpty() || color.isEmpty() || marca.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos Nombre, Color y Marca son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        Vehiculo vehiculo = new Vehiculo(nombre, anio, precio, kilometros, color, marca);
                        vehiculos.add(vehiculo);
                        nombreField.setText("");
                        anioField.setText("");
                        precioField.setText("");
                        kilometrosField.setText("");
                        colorField.setText("");
                        marcaField.setText("");
                        JOptionPane.showMessageDialog(null, "Vehículo agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, "Datos inválidos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        ventanaAgregarVehiculo.add(new JLabel("Nombre:"));
        ventanaAgregarVehiculo.add(nombreField);
        ventanaAgregarVehiculo.add(new JLabel("Año:"));
        ventanaAgregarVehiculo.add(anioField);
        ventanaAgregarVehiculo.add(new JLabel("Precio:"));
        ventanaAgregarVehiculo.add(precioField);
        ventanaAgregarVehiculo.add(new JLabel("Kilómetros:"));
        ventanaAgregarVehiculo.add(kilometrosField);
        ventanaAgregarVehiculo.add(new JLabel("Color:"));
        ventanaAgregarVehiculo.add(colorField);
        ventanaAgregarVehiculo.add(new JLabel("Marca:"));
        ventanaAgregarVehiculo.add(marcaField);
        ventanaAgregarVehiculo.add(new JLabel());
        ventanaAgregarVehiculo.add(agregarButton);
        ventanaAgregarVehiculo.setVisible(true);
    }
    private void abrirVentanaBuscarVehiculos() {
        JFrame ventanaBuscarVehiculos = new JFrame("Buscar Vehículos");
        ventanaBuscarVehiculos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaBuscarVehiculos.setSize(300, 100);
        ventanaBuscarVehiculos.setLayout(new GridLayout(2, 2));
        JTextField marcaBusquedaField = new JTextField();
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marcaBusqueda = marcaBusquedaField.getText();
                List<Vehiculo> resultados = new ArrayList<>();
                for (Vehiculo vehiculo : vehiculos) {
                    if (vehiculo.getMarca().equalsIgnoreCase(marcaBusqueda)) {
                        resultados.add(vehiculo);
                    }
                }
                if (resultados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontraron vehículos con la marca especificada", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder resultadoTexto = new StringBuilder("Resultados de la búsqueda:\n");
                    for (Vehiculo vehiculo : resultados) {
                        resultadoTexto.append("Nombre: ").append(vehiculo.getNombre()).append(", Marca: ").append(vehiculo.getMarca()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, resultadoTexto.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        ventanaBuscarVehiculos.add(new JLabel("Marca a buscar:"));
        ventanaBuscarVehiculos.add(marcaBusquedaField);
        ventanaBuscarVehiculos.add(new JLabel());
        ventanaBuscarVehiculos.add(buscarButton);
        ventanaBuscarVehiculos.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutomotoraGUI();
            }
        });
    }
}