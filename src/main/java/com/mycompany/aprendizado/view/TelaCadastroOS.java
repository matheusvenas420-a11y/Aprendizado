package com.mycompany.aprendizado.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.mycompany.aprendizado.model.OrdemServico;
import com.mycompany.aprendizado.dao.ServicoCRUD_dao;

public class TelaCadastroOS extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Label lblNome = new Label("Nome do cliente:");
        TextField txtNome = new TextField();

        Label lblValor = new Label("Valor:");
        TextField txtValor = new TextField();

        Label lblPrazo = new Label("Prazo:");
        TextField txtPrazo = new TextField();

        Label lblTipo = new Label("Tipo de serviço:");
        ComboBox<String> cbTipo = new ComboBox<>();
        cbTipo.getItems().addAll("Pedreiro", "Eletricista", "Azulejista");

        Button btnCadastrar = new Button("Cadastrar");
        Button btnLimpar = new Button("Limpar");

        btnLimpar.setOnAction(e -> {
            txtNome.clear();
            txtValor.clear();
            txtPrazo.clear();
            cbTipo.setValue(null);
        });

        btnCadastrar.setOnAction(e -> {
            try {
                String nome = txtNome.getText();
                double valor = Double.parseDouble(txtValor.getText());
                int prazo = Integer.parseInt(txtPrazo.getText());
                String tipo = cbTipo.getValue();

                OrdemServico os = new OrdemServico(nome, valor, prazo, tipo);
                ServicoCRUD_dao dao = new ServicoCRUD_dao();
                dao.inserir(os);

                System.out.println("Cadastro realizado com sucesso!");

                txtNome.clear();
                txtValor.clear();
                txtPrazo.clear();
                cbTipo.setValue(null);

            } catch (NumberFormatException ex) {
                System.out.println("Valor ou prazo inválido.");
            } catch (Exception ex) {
                System.out.println("Erro ao cadastrar: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(
                lblNome, txtNome,
                lblValor, txtValor,
                lblPrazo, txtPrazo,
                lblTipo, cbTipo,
                btnCadastrar, btnLimpar
        );

        Scene scene = new Scene(layout, 350, 350);

        stage.setTitle("Cadastro de Ordem de Serviço");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
