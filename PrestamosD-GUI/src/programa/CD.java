package programa;

import java.awt.event.*;
import java.util.Collections;
import java.util.Vector;

import informe.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class CD extends javax.swing.JFrame {
	private JMenuBar jMenuBar;
	private JMenu jmnuArchivo;
	private JMenu jmnuInformes;
	private JMenuItem jmItemAnadirReg;
	private JMenuItem jmItemBuscarReg;
	private JMenuItem jmnuSoloNoPrestados;
	private JMenuItem jmnuSoloPrestado;
	private JMenuItem jmnuInformeCompleto;
	private JMenuItem jmItemSalir;
	private JLabel jlbTitulo;
	private JLabel jblCreditos;
	private JLabel jlbPrestamo;
	private JLabel jblGenero;
	private JLabel jlbAutor;
	private JTextArea jtaPrestamo;
	private JTextField jtfTitulo;
	private JTextField jtfGenero;
	private JTextField jtfAutor;
	private JSeparator jSeparator1;
	private BuscarReg dlgBuscar;
	private InformeJasperCompleto infCompleto;
	private static final long serialVersionUID = 1L;
	private Vector<CDBean> CDs = new Vector<CDBean>();

	/** constructor de clase CD */

	public CD() {
		super();
		initGUI();
	}

	public Vector<CDBean> getCDs() {
		return CDs;
	}

	public void setCDs(Vector<CDBean> item) {

		// CDs.add(new CDBean(titulo, autor, genero, descripcion));
		this.CDs = item;
	}

	/** Inicia ventana */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			setSize(400, 300);
			this.setTitle("CDs prestados");
			this.setResizable(false);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					salirForm();
				}
			});
			{
				jlbTitulo = new JLabel();
				getContentPane().add(jlbTitulo);
				jlbTitulo.setText("Titulo");
				jlbTitulo.setBounds(20, 20, 50, 14);
			}
			{
				jlbAutor = new JLabel();
				getContentPane().add(jlbAutor);
				jlbAutor.setText("Autor");
				jlbAutor.setBounds(20, 60, 50, 14);
			}
			{
				jblGenero = new JLabel();
				getContentPane().add(jblGenero);
				jblGenero.setText("Genero");
				jblGenero.setBounds(20, 100, 50, 14);
			}
			{
				jlbPrestamo = new JLabel();
				getContentPane().add(jlbPrestamo);
				jlbPrestamo.setText("Prestamo");
				jlbPrestamo.setBounds(20, 140, 100, 14);
			}
			{
				jblCreditos = new JLabel();
				getContentPane().add(jblCreditos);
				jblCreditos.setText("copyright 2009 - SoftCIF");
				jblCreditos.setBounds(3, 225, 392, 14);
			}
			{
				jtaPrestamo = new JTextArea();
				getContentPane().add(jtaPrestamo);
				jtaPrestamo.setBounds(100, 137, 275, 70);
				jtaPrestamo.setLineWrap(true);
				jtaPrestamo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
						0));
				jtaPrestamo.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent evt) {
						jtfFocusGained(evt);
					}
				});
			}
			{
				jtfTitulo = new JTextField();
				getContentPane().add(jtfTitulo);
				jtfTitulo.setBounds(100, 17, 275, 21);
				jtfTitulo.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent evt) {
						jtfFocusGained(evt);
					}
				});
			}
			{
				jtfAutor = new JTextField();
				getContentPane().add(jtfAutor);
				jtfAutor.setBounds(100, 57, 275, 21);
				jtfAutor.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent evt) {
						jtfFocusGained(evt);
					}
				});
			}
			{
				jtfGenero = new JTextField();
				getContentPane().add(jtfGenero);
				jtfGenero.setBounds(100, 97, 275, 21);
				jtfGenero.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent evt) {
						jtfFocusGained(evt);
					}
				});
			}
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jmnuArchivo = new JMenu();
					jMenuBar.add(jmnuArchivo);
					jmnuArchivo.setText("Archivo");
					jmnuArchivo.setMnemonic(java.awt.event.KeyEvent.VK_A);
					{
						jmItemAnadirReg = new JMenuItem();
						jmnuArchivo.add(jmItemAnadirReg);
						jmItemAnadirReg.setText("Añadir registro");
						jmItemAnadirReg
								.setMnemonic(java.awt.event.KeyEvent.VK_R);
						jmItemAnadirReg.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jmItemAnadirRegActionPerformed(evt);
							}
						});
					}
					{
						jmItemBuscarReg = new JMenuItem();
						jmnuArchivo.add(jmItemBuscarReg);
						jmItemBuscarReg.setText("Buscar registro");
						jmItemBuscarReg
								.setMnemonic(java.awt.event.KeyEvent.VK_B);
						jmItemBuscarReg.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jmItemBuscarRegActionPerformed(evt);
							}
						});

					}
					{
						jSeparator1 = new JSeparator();
						jmnuArchivo.add(jSeparator1);
					}
					{
						jmItemSalir = new JMenuItem();
						jmnuArchivo.add(jmItemSalir);
						jmItemSalir.setText("Salir");
						jmItemSalir.setMnemonic(java.awt.event.KeyEvent.VK_S);
						jmItemSalir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								salirForm();
							}
						});
					}
					jmnuInformes = new JMenu();
					jMenuBar.add(jmnuInformes);
					jmnuArchivo.setText("Archivo");
					jmnuInformes.setMnemonic(java.awt.event.KeyEvent.VK_I);
					jmnuInformes.setText("Informes");
					{
						jmnuInformeCompleto = new JMenuItem();
						jmnuInformes.add(jmnuInformeCompleto);
						jmnuInformeCompleto.setText("Informe Completo");
						jmnuInformeCompleto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								generaInforme();
							}
						});
					}
					{
						jmnuSoloPrestado = new JMenuItem();
						jmnuInformes.add(jmnuSoloPrestado);
						jmnuSoloPrestado.setText("Solo prestado");
						jmnuSoloPrestado.setBounds(113, 19, 90, 20);
					}
					{
						jmnuSoloNoPrestados = new JMenuItem();
						jmnuInformes.add(jmnuSoloNoPrestados);
						jmnuSoloNoPrestados.setText("Solo No Prestados");
					}
				}
			}

		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public void generaInforme() {
		infCompleto= new InformeJasperCompleto();
		infCompleto.informe();

	}

	private void jmItemBuscarRegActionPerformed(ActionEvent evt) {
		dlgBuscar = new BuscarReg(this);
		dlgBuscar.setVisible(true);
	}

	private void salirForm() {
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Esta acción cerrará la aplicación, ¿desea continuar?",
				"Atención", JOptionPane.YES_NO_OPTION);

		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}
		System.exit(EXIT_ON_CLOSE);
	}

	private void jtfFocusGained(FocusEvent evt) {
		javax.swing.text.JTextComponent jtb = null;
		jtb = (JTextComponent) evt.getSource();

		jtb.selectAll();
	}

	private void jmItemAnadirRegActionPerformed(ActionEvent evt) {
		String titulo = null, autor = null, genero = null, descripcion = null;

		titulo = jtfTitulo.getText().toString();

		// Comprobamos que el titulo no sea nulo
		if (titulo.compareTo("") == 0) {
			JOptionPane.showMessageDialog(null,
					"El campo titulo no puede estar vacio");
			return;
		}

		autor = jtfAutor.getText().toString();
		genero = jtfGenero.getText().toString();
		descripcion = jtaPrestamo.getText().toString();

		CDs.add(new CDBean(titulo, autor, genero, descripcion));
		Collections.sort(CDs);

		if (dlgBuscar != null && dlgBuscar.isVisible())
			dlgBuscar.actualizarLista();

	}

	public void setRegDatos(int i) {
		CDBean cd = CDs.get(i);
		jtfTitulo.setText(cd.getTitulo());
		jtfAutor.setText(cd.getAutor());
		jtfGenero.setText(cd.getGenero());
		jtaPrestamo.setText(cd.getPrestamo());
	}

	/** 1.- metodo principal */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CD inst = new CD();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

}
