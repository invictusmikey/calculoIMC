package calculoImc;



import javax.swing.*;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JTextField txtTalla;
	JButton btnCalcularIMC,btnListaPersonas, btnRegistrar ; 
	JTextArea areaResultado;
	private JScrollPane scroll;

	logica miLogica;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 759);
		contentPane = new JPanel();
		miLogica = new logica(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Calcular IMC");
		etiTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		etiTitulo.setBounds(385, 29, 216, 89);
		contentPane.add(etiTitulo);
		
		JLabel lblNewLabel = new JLabel("Datos basicos :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(58, 131, 216, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Documento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(58, 229, 102, 22);
		contentPane.add(lblNewLabel_1);
		
		txtDocumento = new JTextField();
		txtDocumento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDocumento.setBounds(170, 233, 104, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(299, 236, 75, 15);
		contentPane.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNombre.setBounds(387, 233, 368, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Edad:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(771, 236, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEdad.setBounds(830, 233, 57, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Datos IMC:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(58, 319, 128, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Peso:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(58, 384, 49, 22);
		contentPane.add(lblNewLabel_5);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(129, 384, 96, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Talla:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(299, 391, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		txtTalla = new JTextField();
		txtTalla.setBounds(358, 388, 96, 20);
		contentPane.add(txtTalla);
		txtTalla.setColumns(10);
		
		JLabel etiResultado = new JLabel("Resultado:");
		etiResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		etiResultado.setBounds(58, 466, 128, 22);
		contentPane.add(etiResultado);
		
	
		
		btnCalcularIMC = new JButton("Calcular IMC");
		btnCalcularIMC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalcularIMC.setBounds(658, 666, 216, 23);
		contentPane.add(btnCalcularIMC);
		btnCalcularIMC.addActionListener(this);
		
		btnListaPersonas = new JButton("Lista Personas");
		btnListaPersonas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListaPersonas.setBounds(428, 666, 205, 23);
		contentPane.add(btnListaPersonas);
		btnListaPersonas.addActionListener(this);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrar.setBounds(215, 666, 173, 23);
		contentPane.add(btnRegistrar);
		
		
	;
		
		areaResultado = new JTextArea();
		areaResultado.setFont(new Font("Verdana", Font.PLAIN, 20));
		areaResultado.setText("info");
		areaResultado.setBounds(58, 499, 797, 156);
		areaResultado.setLineWrap(true);
		contentPane.add(areaResultado);
		btnRegistrar.addActionListener(this);
		
		scroll = new JScrollPane();
		scroll.setViewportView(areaResultado);
		scroll.setBounds(58, 499, 797, 156);
		contentPane.add(scroll);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnRegistrar) {
			personaVO miPersona = new personaVO();
			miPersona.setDocumento(txtDocumento.getText());
			miPersona.setNombre(txtNombre.getText());
			miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
			miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			
			
			String res=miLogica.registrarPersona(miPersona);	
			areaResultado.setText(res);
			
		}else if(e.getSource() == btnListaPersonas) {
			String resultado =miLogica.consultarListaPersonas();
			areaResultado.setText(resultado);
			
		}else if(e.getSource() == btnCalcularIMC) {
			String resultado = miLogica.consultarpromedio();
			areaResultado.setText(resultado);
			
		}
	}
}
