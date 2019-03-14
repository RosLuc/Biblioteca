/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notificar;

import Classes.Material;
import Emprestimo.Emprestimo;
import java.util.Set;

/**
 *
 * @author maria
 */
public class Notificar {
    
    
   /**
    * Método responsavel pro gerar a menssagem de notificação de emprestimo. 
    * @param nome String com o nome da pessoa
    * @param emp Objeto do emprestimo
    * @return Retorna uma string contendo a menssagem de emprestimo
    */
   public static String notificarEmprestimo(String nome, Emprestimo emp){
        String notEmp = "\tEmpréstimos realizados)\nCaro(a)" + nome +",\nOs emprestimo abaixo foram realizados com sucesso:\n"
               + "Data do Empréstimo: " + emp.getDataemp() + "Data para devolução: " + emp.getDatadev() + "Materiais:\n ";
        String materiais = "";
        Set<Material> mat = emp.getMateriais();
        for(Material x : mat){
            materiais += (x.getNchamada() + x.getTitulo());
        }
       return notEmp + materiais;
   }
   
   /**
    * Método responsavel pro gerar a menssagem de notificação de atraso. 
    * @param nome String com o nome da pessoa
    * @param emp Objeto do emprestimo
    * @return Retorna uma string contendo a menssagem de atraso
    */
   public static String notificarAtraso(String nome, Emprestimo emp){
        String notEmp = "\tEmprestimos atrasados\nCaro(a)" + nome +",\nO(s) emprestimo(s) do(s) material(is) ";
       
        String materiais = "";
        Set<Material> mat = emp.getMateriais();
        for(Material x : mat){
            materiais += x.getNchamada() + x.getTitulo(); 
        }
        return notEmp + materiais + "venceu dia" +emp.getDatadev()+ "Não esqueça de devolve-lo";
   }
   
   /**
    * Método responsavel pro gerar a menssagem de notificação de devolução. 
    * @param nome String com o nome da pessoa
    * @param emp Objeto do emprestimo
    * @return Retorna uma string contendo a menssagem de devolução
    */
   public static String notificarDevolucao(String nome, Emprestimo emp){
        String notEmp = "\tEmpréstimo Devolvidos\nCaro(a)" + nome +",\nOs emprestimo abaixo foram devolvidos com sucesso:\n"
               + "Materiais:\n ";
        String materiais = "";
        Set<Material> mat = emp.getMateriais();
        for(Material x : mat){
            materiais += x.getNchamada() + x.getTitulo(); 
        }
       return notEmp + materiais;
   } 
   
}