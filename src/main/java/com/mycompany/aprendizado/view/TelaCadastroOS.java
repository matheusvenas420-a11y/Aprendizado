package com.mycompany.aprendizado.view;

import com.mycompany.aprendizado.dao.ServicoCRUD_dao;
import com.mycompany.aprendizado.model.OrdemServico;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCadastroOS extends Application {

    @Override
    public void start(Stage stage) {
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
        Button btnListar = new Button("Listar");

        TableView<OrdemServico> tabela = new TableView<>();

        TableColumn<OrdemServico, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<OrdemServico, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<OrdemServico, Double> colValor = new TableColumn<>("Valor");
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        TableColumn<OrdemServico, Integer> colPrazo = new TableColumn<>("Prazo");
        colPrazo.setCellValueFactory(new PropertyValueFactory<>("prazo"));

        TableColumn<OrdemServico, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo_servico"));

        tabela.getColumns().addAll(colId, colNome, colValor, colPrazo, colTipo);
        tabela.setPrefHeight(200);

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

                ObservableList<OrdemServico> dados = FXCollections.observableArrayList(dao.listar());
                tabela.setItems(dados);

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

        btnListar.setOnAction(e -> {
            ServicoCRUD_dao dao = new ServicoCRUD_dao();
            ObservableList<OrdemServico> dados = FXCollections.observableArrayList(dao.listar());
            tabela.setItems(dados);
        });

        ServicoCRUD_dao dao = new ServicoCRUD_dao();
        ObservableList<OrdemServico> dados = FXCollections.observableArrayList(dao.listar());
        tabela.setItems(dados);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(
                lblNome, txtNome,
                lblValor, txtValor,
                lblPrazo, txtPrazo,
                lblTipo, cbTipo,
                btnCadastrar, btnLimpar, btnListar,
                tabela
        );

        Scene scene = new Scene(layout, 500, 550);

        stage.setTitle("Cadastro de Ordem de Serviço");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}