package sistemas_de_alunos_avançado;

import java.util.Scanner;

public class sistema_de_alunos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nomes = new String[5];
        double[] notas = new double[5];
        double[] notas2 = new double[5];
        int contador = 0;

        int menu = 0;

        while (menu != 8) {
            System.out.println("-----RELATÓRIO DE ALUNOS-----");
            System.out.println();
            System.out.println("1 - CADASTRAR ALUNO");
            System.out.println("2 - LISTAR ALUNOS");
            System.out.println("3 - MOSTRAR MÉDIA INDIVIDUAL");
            System.out.println("4 - MOSTRAR MÉDIA DA TURMA");
            System.out.println("5 - MOSTRAR A MAIOR NOTA");
            System.out.println("6 - MOSTRAR A MENOR NOTA");
            System.out.println("7 - MOSTRAR APROVADOS E REPROVADOS");
            System.out.println("8 - SAIR");

            menu = sc.nextInt();

            switch (menu) {

                case 1:
                    if (contador < 5) {
                        sc.nextLine();

                        System.out.println("DIGITE O NOME DO ALUNO:");
                        nomes[contador] = sc.nextLine();

                        System.out.println("DIGITE A PRIMEIRA NOTA:");
                        notas[contador] = sc.nextDouble();

                        System.out.println("DIGITE A SEGUNDA NOTA:");
                        notas2[contador] = sc.nextDouble();

                        contador++;
                    } else {
                        System.out.println("LIMITE DE ALUNOS ATINGIDO!");
                    }
                    break;

                case 2:
                    if (contador == 0) {
                        System.out.println("NENHUM ALUNO CADASTRADO!");
                    } else {
                        for (int i = 0; i < contador; i++) {
                            System.out.println("ALUNO: " + nomes[i] +
                                    " | NOTA 1: " + notas[i] +
                                    " | NOTA 2: " + notas2[i]);
                        }
                    }
                    break;

                case 3:
                    if (contador == 0) {
                        System.out.println("NENHUM ALUNO CADASTRADO!");
                    } else {
                        sc.nextLine();
                        System.out.println("DIGITE O NOME DO ALUNO:");
                        String busca = sc.nextLine();

                        boolean encontrado = false;

                        for (int i = 0; i < contador; i++) {
                            if (nomes[i].equalsIgnoreCase(busca)) {
                                double media = (notas[i] + notas2[i]) / 2;
                                System.out.println(nomes[i] + " | MÉDIA: " + media);
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("ALUNO NÃO ENCONTRADO!");
                        }
                    }
                    break;

                case 4:
                    if (contador == 0) {
                        System.out.println("NENHUM ALUNO CADASTRADO!");
                    } else {
                        double somaMedias = 0;

                        for (int i = 0; i < contador; i++) {
                            double media = (notas[i] + notas2[i]) / 2;
                            somaMedias += media;
                        }

                        System.out.println("MÉDIA DA TURMA: " + (somaMedias / contador));
                    }
                    break;

                case 5:
                    if (contador == 0) {
                        System.out.println("NENHUM ALUNO CADASTRADO!");
                    } else {
                        double maior = (notas[0] + notas2[0]) / 2;

                        for (int i = 1; i < contador; i++) {
                            double media = (notas[i] + notas2[i]) / 2;
                            if (media > maior) {
                                maior = media;
                            }
                        }

                        System.out.println("MAIOR MÉDIA: " + maior);
                    }
                    break;

                case 6:
                    if (contador == 0) {
                        System.out.println("NENHUM ALUNO CADASTRADO!");
                    } else {
                        double menor = (notas[0] + notas2[0]) / 2;

                        for (int i = 1; i < contador; i++) {
                            double media = (notas[i] + notas2[i]) / 2;
                            if (media < menor) {
                                menor = media;
                            }
                        }

                        System.out.println("MENOR MÉDIA: " + menor);
                    }
                    break;

                case 7:
                    if (contador == 0) {
                        System.out.println("NENHUM ALUNO CADASTRADO!");
                    } else {

                        int aprovados = 0;
                        int recuperacao = 0;
                        int reprovados = 0;

                        for (int i = 0; i < contador; i++) {

                            double media = (notas[i] + notas2[i]) / 2;

                            if (media >= 6) {
                                aprovados++;
                            } else if (media >= 5) {
                                recuperacao++;
                            } else {
                                reprovados++;
                            }
                        }

                        System.out.println("APROVADOS: " + aprovados);
                        System.out.println("RECUPERAÇÃO: " + recuperacao);
                        System.out.println("REPROVADOS: " + reprovados);
                    }
                    break;

                case 8:
                    System.out.println("SAINDO...");
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
        }

        sc.close();
    }
}                			