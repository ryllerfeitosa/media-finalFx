package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.concurrent.Delayed;

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
        buttonCalcularMedia.setPrefHeight(40);
        buttonCalcularMedia.setPrefWidth(100);
        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefHeight(40);
        buttonLimpar.setPrefWidth(100);
        Button buttonSair = new Button("Sair");
        buttonSair.setPrefHeight(40);
        buttonSair.setPrefWidth(100);
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
        root.setLeft(painelFormulario);
        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setRight(painelDeBotoes);

        stage.setScene(scene);   //Mostrar a cena


        //Mostrar o stage (tela)
        stage.show();

        //eventos de clique dos botões
        buttonCalcularMedia.setOnAction(click ->{
            System.out.println("Botão clicado!");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do aluno: " + nomeDigitado);

            //calcular média
            //obter notas

            //Criar um vetor de notas (array)
            double[] notas = new double[4];
            String[] notasStr = new String[4];

            notasStr[0] = textFieldNota1.getText();
            notas[0] = Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2] = textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

            notasStr[3] = textFieldNota4.getText();
            notas[3] = Double.parseDouble(notasStr[3]);

            //uso de loop while(ENQUANTO) para somar as notas
            int volta = 0;
            double mediaFinalDoAluno = 0;
            while (volta < notas.length ){
                //mediaFinalDoAluno = mediaFinalDoAluno + notas[volta];  //a mediaFinalDoAluno
                //sempre incrementa a cada volta o valor da nota e soma com a nova nota
                mediaFinalDoAluno += notas[volta];
                volta++;
            }

            mediaFinalDoAluno = mediaFinalDoAluno/notas.length;
            String mediaFinalStr = String.format("%.1f", mediaFinalDoAluno);
            labelMediaFinal.setText("Média final: " + mediaFinalStr);

            //Resultado final
            if (mediaFinalDoAluno >= 6){
                labelSituacao.setText("Situação: Aprovado");
            }else if (mediaFinalDoAluno <4){
                labelSituacao.setText("Situação: Reprovado");
            } else if (mediaFinalDoAluno == 4 || mediaFinalDoAluno == 5) {
                labelSituacao.setText("Situação: Recuperação");
            }


        });
        buttonLimpar.setOnAction(click ->{
            textFieldNome.clear();
            textFieldNota1.clear();
            textFieldNota2.clear();
            textFieldNota3.clear();
            textFieldNota4.clear();
            labelAluno.setText("Nome do aluno: ");
            labelMediaFinal.setText("Média final: ");
            labelSituacao.setText("Situação: ");
            textFieldNome.requestFocus();
        });

        buttonSair.setOnAction(click ->{
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Confirmar a saída?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> botaoPressionado = alerta.showAndWait();
            if (botaoPressionado.get() == ButtonType.YES) {
                Alert alerta2 = new Alert(Alert.AlertType.INFORMATION, "Até logo!");
                alerta2.showAndWait();
                System.exit(0);
            }
        });
    }


}
