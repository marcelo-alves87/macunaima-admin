package org.macunaima.client.application;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.macunaima.client.gui.event.ActionListener;
import org.macunaima.client.gui.event.EventBus;
import org.macunaima.client.printer.Printer;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Filial;
import org.macunaima.domain.Registro;
import org.macunaima.domain.RegistroCallback;
import org.macunaima.service.DefaultService;

public class Application implements LocalizacaoApplication, ValidacaoClienteApplication {

	public interface Display {

		JPasswordField getUserInput();

		int showAskMessage(String cliente, String empresa);

		void clearInput();

		void showUserNotFoundMessage();

		void disable();

		void enable();

		void focus();

		void showDefaultTheme();

		void showDarkTheme();

		void setLogotipo(File logotipo);

		void setFilialNome(String nome);

		JLabel getPrimeiroAcessoTextField();

		boolean isEnabled();

	}

	private Display display;
	private boolean isFetching;
	private EventBus eventBus;

	public Application(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public void setDisplay(Display display) {
		this.display = display;
		bind();
		fetch();
	}

	private void fetch() {
		String id = Resource.getFilialId();
		if (id != null) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Filial filial = DefaultService.getFilialController().findById(id);
					display.setLogotipo(filial.getLogotipo());
					display.setFilialNome(filial.getNome());
				}
			});
		}
	}

	private void bind() {
		display.getUserInput().getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				findText();

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				findText();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				findText();

			}
		});

		display.getPrimeiroAcessoTextField().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				openPrimeiroAcesso();
			}

		});
	}

	private void findText() {
		String input = display.getUserInput().getText();
		fetch(input);
	}

	private void fetch(String input) {
		if (!isFetching && input != null && !input.isEmpty()) {
			isFetching = true;
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					if (input.equals("1")) {
						openFiliais();
					} else {
						try {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									Cliente cliente = DefaultService.getClienteController().findDigital(input);
									openInput(cliente);
								}
							});
						} catch (Exception e) {
							close();
						}
					}
				}

			});

		}

	}

	protected void openPrimeiroAcesso() {
		if (display.isEnabled()) {
			display.disable();
			display.showDarkTheme();
			eventBus.openDialogPrimeiroAcesso(this);
		}
	}

	private void openFiliais() {
		display.disable();
		display.showDarkTheme();
		Vector<Filial> filials = DefaultService.getFilialController().findAll();
		eventBus.openFiliaisDialog(filials);
	}

	private void openInputButtons(Cliente cliente) {
		eventBus.showMessage(cliente.getEmpresa().getDescontoCredito(), cliente.getEmpresa().getDescontoAVista(),
				new ActionListener() {

					@Override
					public void actionPerformed() {
						createRegistro(cliente, false);

					}
				}, new ActionListener() {

					@Override
					public void actionPerformed() {
						createRegistro(cliente, true);

					}
				});
	}

	private void createRegistro(Cliente cliente, boolean desconto) {
		Registro registro = new Registro();
		DefaultService.getClienteController().incrementarUtilizacoes(cliente);
		registro.setCliente(cliente);
		Filial filial = new Filial();
		filial.setId(Resource.getFilialId());
		registro.setFilial(filial);
		registro.setDesconto(desconto);
		RegistroCallback registroCallback = DefaultService.getRegistroController().persistRegistro(registro);
		if (registroCallback != null) {
			showSucessMessage();
			Printer.print(registroCallback);
		} else {
			showErrorMessage();
		}

	}

	private void showErrorMessage() {
		showMessage(
				"Desculpe, houve um erro ao registrar seu cupom de desconto. Por favor, procure um funcionário mais próximo.");

	}

	protected void showSucessMessage() {
		showMessage(
				"Aguarde a impressão do cupom de desconto e apresente no caixa.<br>Obrigado por usar nossos serviços.");

	}

	private void openInput(Cliente cliente) {
		display.disable();
		display.showDarkTheme();
		if (cliente != null)
			showMessage(cliente, new ActionListener() {

				@Override
				public void actionPerformed() {
					openInputButtons(cliente);

				}
			});
		else
			showMessage("Usuário não encontrado. Por favor, tente novamente.");
	}

	public void close() {
		display.enable();
		isFetching = false;
		display.clearInput();
		display.focus();
		display.showDefaultTheme();
	}

	@Override
	public void findCliente(String codigoLocalizador) {
		Cliente cliente = DefaultService.getClienteController().findCodigoLocalizador(codigoLocalizador);
		if (cliente != null) {
			openWelcomeMessage(cliente);
		} else {
			showMessage("Cliente não encontrado. Por favor, tente novamente.");
		}
	}

	private void openWelcomeMessage(Cliente cliente) {
		display.disable();
		display.showDarkTheme();
		if (cliente != null)
			showMessage(cliente, new ActionListener() {

				@Override
				public void actionPerformed() {
					openValidarClienteDialogBox(cliente);

				}
			});
	}

	private void openValidarClienteDialogBox(Cliente cliente) {
		display.disable();
		display.showDarkTheme();
		if (cliente != null)
			eventBus.openValidarClienteDialogBox(cliente, this);
	}

	private void openCadastrarDigital2(Cliente cliente) {
		eventBus.showCadastrarDigital2DialogBox(cliente, new ActionListener() {

			@Override
			public void actionPerformed() {
				persistCliente(cliente);
			}
		});

	}

	private void persistCliente(Cliente cliente) {
		Callback callback = DefaultService.getClienteController().persist(cliente, true);
		if (callback.callBack() == 1) {
			showMessage("Cadastro do cliente realizado com sucesso. Comece já a usar os nossos serviços.");
		} else {
			showMessage("Não foi possível realizar o cadastro do cliente. Por favor, tente novamente.");
		}
	}

	@Override
	public void getValidacaoClienteActionListener(Cliente cliente) {
		eventBus.showCadastrarDigital1DialogBox(cliente, new ActionListener() {

			@Override
			public void actionPerformed() {
				openCadastrarDigital2(cliente);

			}
		});
	}

	@Override
	public int getMesDataNascimentoCliente(Cliente cliente) {
		int month = 0;
		if (cliente != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(cliente.getDataNascimento());
			month = calendar.get(Calendar.MONTH);
		}
		return month;
	}

	private void showMessage(String message) {
		display.disable();
		display.showDarkTheme();
		eventBus.showMessage(message);
	}

	private void showMessage(Cliente cliente, ActionListener actionListener) {
		display.disable();
		display.showDarkTheme();
		eventBus.showMessage(cliente.getNome(), cliente.getEmpresa().getNome(), actionListener);
	}
}
