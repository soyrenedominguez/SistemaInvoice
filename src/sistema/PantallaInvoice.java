package sistema;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInvoice {

	private JFrame frmSistemaInvoice;
	private JTextField txtInvoiceId;
	private JTextField txtNumber;
	private JTextField txtCustomerName;
	private JTextField txtIssueDate;
	private JTextField txtTotalAmount;
	private JTextField txtPaid;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInvoice window = new PantallaInvoice();
					window.frmSistemaInvoice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PantallaInvoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaInvoice = new JFrame();
		frmSistemaInvoice.setTitle("SISTEMA INVOICE");
		frmSistemaInvoice.setBounds(100, 100, 481, 347);
		frmSistemaInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaInvoice.getContentPane().setLayout(null);

		JLabel lblInvoiceId = new JLabel("InvoiceId");
		lblInvoiceId.setBounds(37, 33, 99, 20);
		frmSistemaInvoice.getContentPane().add(lblInvoiceId);

		txtInvoiceId = new JTextField();
		txtInvoiceId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtInvoiceId.getText().length() >= 11) {
					e.consume();
				}
			}
		});
		txtInvoiceId.setBounds(146, 33, 159, 20);
		frmSistemaInvoice.getContentPane().add(txtInvoiceId);
		txtInvoiceId.setColumns(10);

		txtNumber = new JTextField();
		txtNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNumber.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtNumber.setColumns(10);
		txtNumber.setBounds(146, 64, 159, 20);
		frmSistemaInvoice.getContentPane().add(txtNumber);

		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(37, 64, 99, 20);
		frmSistemaInvoice.getContentPane().add(lblNumber);

		txtCustomerName = new JTextField();
		txtCustomerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCustomerName.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(146, 95, 159, 20);
		frmSistemaInvoice.getContentPane().add(txtCustomerName);

		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(37, 95, 99, 20);
		frmSistemaInvoice.getContentPane().add(lblCustomerName);

		txtIssueDate = new JTextField();
		txtIssueDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtIssueDate.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtIssueDate.setColumns(10);
		txtIssueDate.setBounds(146, 126, 159, 20);
		frmSistemaInvoice.getContentPane().add(txtIssueDate);

		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setBounds(37, 126, 99, 20);
		frmSistemaInvoice.getContentPane().add(lblIssueDate);

		txtTotalAmount = new JTextField();
		txtTotalAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTotalAmount.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtTotalAmount.setColumns(10);
		txtTotalAmount.setBounds(146, 158, 159, 20);
		frmSistemaInvoice.getContentPane().add(txtTotalAmount);

		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(37, 158, 99, 20);
		frmSistemaInvoice.getContentPane().add(lblTotalAmount);

		txtPaid = new JTextField();
		txtPaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPaid.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtPaid.setColumns(10);
		txtPaid.setBounds(146, 188, 159, 20);
		frmSistemaInvoice.getContentPane().add(txtPaid);

		JLabel lblPaid = new JLabel("Paid");
		lblPaid.setBounds(37, 188, 99, 20);
		frmSistemaInvoice.getContentPane().add(lblPaid);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 257, 89, 23);
		frmSistemaInvoice.getContentPane().add(btnAgregar);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(JOptionPane.showInputDialog("ID A CARGAR?"));
					Invoice i = new Invoice();
					i.setInvoiceId(id);
					if (i.cargarInvoice()) {
						txtInvoiceId.setText("" + i.getInvoiceId());
						txtCustomerName.setText(i.getCustomerName());
						txtIssueDate.setText(i.getIssueDate());
						txtNumber.setText(i.getNumber());
						txtTotalAmount.setText(i.getTotalAmount());
						txtPaid.setText(i.getPaid());
						JOptionPane.showMessageDialog(null, "CARGO CORRECTAMENTE");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR AL CARGAR");
				}

			}
		});
		btnCargar.setBounds(119, 257, 89, 23);
		frmSistemaInvoice.getContentPane().add(btnCargar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(233, 257, 89, 23);
		frmSistemaInvoice.getContentPane().add(btnEliminar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(356, 257, 89, 23);
		frmSistemaInvoice.getContentPane().add(btnActualizar);
	}
}
