package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import viewmodel.RegisterParentViewModel;

import java.rmi.RemoteException;

public class RegisterParentViewController extends ViewController
{
  private RegisterParentViewModel viewModel;
  @FXML private TextField firstName;
  @FXML private TextField lastName;
  @FXML private TextField username;
  @FXML private TextField email;
  @FXML private PasswordField password;
  @FXML private RadioButton hasPets;
  @FXML private RadioButton doesNotHavePets;
  @FXML private Label errorLabel;

  @Override protected void init()
  {
    viewModel = getViewModelFactory().getRegisterParentViewModel();
    firstName.textProperty().bindBidirectional(viewModel.getFirstName());
    lastName.textProperty().bindBidirectional(viewModel.getLastName());
    username.textProperty().bindBidirectional(viewModel.getUsername());
    email.textProperty().bindBidirectional(viewModel.getEmail());
    password.textProperty().bindBidirectional(viewModel.getPassword());
    hasPets.selectedProperty()
        .bindBidirectional(viewModel.getHasPets());
    errorLabel.textProperty().bind(viewModel.getError());
  }

  @Override public void reset()
  {
viewModel.reset();
  }

  public void onRegister() throws RemoteException
  {
    if (viewModel.register())
    {
      onLogIn();
    }

    if (viewModel.registerWithRequiredData())
    {
      onLogIn();
    }
  }

  public void onLogIn()
  {
    getViewHandler().openView(View.LOGIN_VIEW);
  }
}
