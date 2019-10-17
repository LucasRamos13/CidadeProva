/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoCidade;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Cidade;
import tela.manutencao.ManutencaoCidade;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class ControladorCidade {
    public static void inserir(ManutencaoCidade man){
        Cidade objeto = new Cidade();
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setNome(man.jtfNome.getText());
        objeto.setDistancia(Double.parseDouble(man.jtfDistancia.getText()));
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
        objeto.setHabitantes(Integer.parseInt(man.jtfHabitantes.getText()));
        objeto.setEmancipacao(LocalDate.parse(man.jtfEmancipacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        boolean resultado = DaoCidade.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    
    public static void alterar(ManutencaoCidade man){
        Cidade objeto = new Cidade();
        //definir todos os atributos
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setNome(man.jtfNome.getText());
        objeto.setDistancia(Double.parseDouble(man.jtfDistancia.getText()));
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
        objeto.setHabitantes(Integer.parseInt(man.jtfHabitantes.getText()));
        objeto.setEmancipacao(LocalDate.parse(man.jtfEmancipacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        
        boolean resultado = DaoCidade.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
     public static void excluir(ManutencaoCidade man){
        Cidade objeto = new Cidade();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoCidade.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     
     public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Sigla");
        modelo.addColumn("Habitantes");
        modelo.addColumn("Emancipação");
        modelo.addColumn("Área");
        modelo.addColumn("Distância da capital");
        List<Cidade> resultados = DaoCidade.consultar();
        for (Cidade objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getSigla());
            linha.add(objeto.getHabitantes());
            linha.add(objeto.getEmancipacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getArea());
            linha.add(objeto.getDistancia());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
     
     public static void atualizaCampos(ManutencaoCidade man, int pk){ 
        Cidade objeto = DaoCidade.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNome.setText(objeto.getNome());
        man.jtfSigla.setText(objeto.getSigla());
        man.jtfHabitantes.setText(objeto.getHabitantes().toString());
        man.jtfEmancipacao.setText(objeto.getEmancipacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfArea.setText(objeto.getArea().toString());
        man.jtfDistancia.setText(objeto.getDistancia().toString());
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
     
     
}
