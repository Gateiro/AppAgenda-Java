package view;

import controller.Lista;
import model.ListaDAO;
import java.util.Scanner;

public class viewLista {

    public static void main(String[] args) {
        inputLista();
    }

    static Scanner sc = new Scanner(System.in);
    static ListaDAO listaDAO = new ListaDAO();

    private static void inputLista() {
        System.out.println("------ NOVA LISTA ------");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        Lista lista = new Lista(nome);
        boolean sucesso = listaDAO.inserirLista(lista);

        if (sucesso) {
            lista.cadastroSucesso();
        } else {
            lista.cadastroErro();
        }
    }

    private static void updateLista() {
        System.out.println("------ ATUALIZAR LISTA ------");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        if (nome.isEmpty()){
            System.out.println("Campo obrigatorio");

        }
        else{
            listaDAO.atualizarLista(id, nome);
        }
    }


}
