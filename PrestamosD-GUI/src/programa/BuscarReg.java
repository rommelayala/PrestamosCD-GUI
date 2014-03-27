package programa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class BuscarReg extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	private CD ventanaPadre;	
	private JButton jbtAceptar;
	private JButton jbtBorrar;
	private JScrollPane jScrollPane1;
	private JList<Object> jlsListaCDs;
	private JButton jbtCancelar;

	public BuscarReg(JFrame frame) {
		super(frame);
		initGUI();
		ConexionDB.getConexion();
		
		ventanaPadre= (CD)frame;
		ventanaPadre.setCDs(operacionDB.getListaDiscos());
		jlsListaCDs.setListData(ventanaPadre.getCDs());		

	}
	
	/**construye la ventana*/
	private void initGUI() {
		try {
			{
				this.setResizable(false);
				this.setTitle("Buscar Registro");
				getContentPane().setLayout(null);
				{
					jbtAceptar = new JButton();
					getContentPane().add(jbtAceptar);
					jbtAceptar.setText("Aceptar");
					jbtAceptar.setBounds(285, 22, 90, 26);
					jbtAceptar.setMnemonic(java.awt.event.KeyEvent.VK_A);
					jbtAceptar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							jbtAceptarActionPerformed(e);
							
						}
					});;
				}
				{
					jbtCancelar = new JButton();
					getContentPane().add(jbtCancelar);
					jbtCancelar.setText("Cancelar");
					jbtCancelar.setBounds(285, 58, 90, 26);
					jbtCancelar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							jbtCancelarActionPerformed(e);
							
						}
					});
				}
				{
					jbtBorrar = new JButton();
					getContentPane().add(jbtBorrar);
					jbtBorrar.setText("Borrar");
					jbtBorrar.setBounds(285, 95, 90, 26);
					jbtBorrar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							jbtBorrarActionPerformed(e);
							
						}
					});
				}
				{
					jScrollPane1 = new JScrollPane();
					getContentPane().add(jScrollPane1);
					jScrollPane1.	setBounds(17, 21, 247, 220);
					{
						jlsListaCDs = new JList<Object>();
						jScrollPane1.setViewportView(jlsListaCDs);
						jlsListaCDs.setName("jlsListaCDs");
					}
				}
			}
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**Metodos de la clase*/
	public void actualizarLista() {
		jlsListaCDs.setListData(ventanaPadre.getCDs());
	}
	
	private void jbtAceptarActionPerformed(ActionEvent evt) {
		int i=jlsListaCDs.getSelectedIndex();
		if (i>=0)
			ventanaPadre.setRegDatos(i);
	}
	private void jbtCancelarActionPerformed(ActionEvent evt) {
		this.setVisible(false);
		this.dispose();
	}
	private void jbtBorrarActionPerformed(ActionEvent evt) {
		int i=jlsListaCDs.getSelectedIndex();
		if (i>=0) {
			ventanaPadre.getCDs().remove(i);
			
			this.actualizarLista();
		}
	}
	/**
	* ejecutar desde la clase CD!!!
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				 javax.swing.JFrame frame = new javax.swing.JFrame();
				BuscarReg inst = new BuscarReg(frame);
				inst.setVisible(true);
			}
		});
	}

}
