package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MediaFinalApp extends Application {//MediaFinalApp é uma aplicação, sendo
    //a MediaFinalApp a filha e o Applocation a mãe

    public static void main(String[] args) {
        launch(args);
    }
    @Override   //Sobre-escreve sobre o palco
    public void start(Stage stage) throws Exception {
        //Determinar o tamanho do stage
        stage.setWidth(600);
        stage.setHeight(500);

        //Determinar o título do stage (tela/janela)
        stage.setTitle("Média final");

        //Painel raiz (root)
        BorderPane root  = new BorderPane();

        Label labelTitulo = new Label();
        labelTitulo.setText("Escola \"Prof. vicente Amato\"");  //Título da página
        //Formatação do texto da label
        labelTitulo.setStyle("-fx-text-fill: #005aff; -fx-font-size: 32; -fx-font-weight: bold;");
        labelTitulo.setPadding(new Insets(10,0,10,10));

        //painel de resultados - Parte de baixo
        VBox painelResultado = new VBox();

        Label labelAluno = new Label("Nome do aluno: ");
        Label labelMediaFinal = new Label("Média final: ");
        Label labelSituacao = new Label("Situação: ");
        painelResultado.getChildren().addAll(labelAluno, labelMediaFinal, labelSituacao);
        painelResultado.setPadding(new Insets(0,0,10,10));
        Scene scene = new Scene(root);

        //Painel de botões
        VBox painelDeBotoes = new VBox();
        Button buttonCalcularMedia = new Button("Calcular média");
        buttonCalcularMedia.setPrefHeight(150);
        buttonCalcularMedia.setPrefWidth(30);
        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefWidth(150);
        buttonLimpar.setPrefHeight(30);
        Button buttonSair = new Button("Sair");
        buttonSair.setPrefHeight(150);
        buttonSair.setPrefWidth(30);
        painelDeBotoes.getChildren().addAll(buttonCalcularMedia,buttonLimpar,buttonSair);
        painelDeBotoes.setPadding(new Insets(0,10,10,0));
        painelDeBotoes.setSpacing(10);

        //Painel formulário
        VBox painelFormulario = new VBox();
        Label labelNome = new Label("Nome do aluno:");
        Label labelNota1 = new Label("Nota 1:");
        Label labelNota2 = new Label("Nota 2:");
        Label labelNota3 = new Label("Nota 3:");
        Label labelNota4 = new Label("Nota 4:");
        TextField textFieldNome = new TextField();
        TextField textFieldNota1 = new TextField();
        TextField textFieldNota2 = new TextField();
        TextField textFieldNota3 = new TextField();
        TextField textFieldNota4 = new TextField();
        painelFormulario.setPadding(new Insets(0,0,10,10));
        painelFormulario.getChildren().addAll(
                labelNome,
                textFieldNome,
                labelNota1,
                textFieldNota1,
                labelNota2,
                textFieldNota2,
                labelNota3,
                textFieldNota3,
                labelNota4,
                textFieldNota4
        );
        root.setCenter(painelFormulario);
        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setRight(painelDeBotoes);

        stage.setScene(scene);   //Mostrar a cena


        //Mostrar o stage (tela)
        stage.show();

    }


}
