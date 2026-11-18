package concessionaria.view;

import concessionaria.controller.Operations;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/* tela de Read, Update e Delete */
public class TelaUpdate extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaUpdate.class.getName());

    Operations op = new Operations();
    List<String[]> registros;                                        // registros que vieram do banco
    DefaultListModel<String> modeloClientes = new DefaultListModel<>();
    DefaultListModel<String> modeloServicos = new DefaultListModel<>();

    public TelaUpdate() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListadeClientes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListadeServicos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaServico = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaPagamento = new javax.swing.JList<>();
        IdBusca = new javax.swing.JTextField();
        Nome = new javax.swing.JTextField();
        Contato = new javax.swing.JTextField();
        Marca = new javax.swing.JTextField();
        Ano = new javax.swing.JTextField();
        botaoBuscar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        botaoListarTodos = new javax.swing.JButton();
        botaoListarServico = new javax.swing.JButton();
        botaoListarPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar serviço");
        getContentPane().setLayout(null);

        // ---------- listas (READ) ----------
        jLabel1.setText("Clientes");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 100, 20);

        jLabel2.setText("Veículo / Serviço / Pagamento");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 10, 250, 20);

        ListadeClientes.setModel(modeloClientes);
        ListadeClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListadeClientes.addListSelectionListener(this::ListadeClientesValueChanged);
        jScrollPane1.setViewportView(ListadeClientes);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 35, 270, 150);

        ListadeServicos.setModel(modeloServicos);
        ListadeServicos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListadeServicos.addListSelectionListener(this::ListadeServicosValueChanged);
        jScrollPane2.setViewportView(ListadeServicos);
        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(300, 35, 300, 150);

        // ---------- consultas (só aqui as listas são atualizadas) ----------
        botaoListarTodos.setText("Listar todos");
        botaoListarTodos.addActionListener(this::botaoListarTodosActionPerformed);
        getContentPane().add(botaoListarTodos);
        botaoListarTodos.setBounds(20, 190, 180, 25);

        botaoListarServico.setText("Listar por serviço");
        botaoListarServico.addActionListener(this::botaoListarServicoActionPerformed);
        getContentPane().add(botaoListarServico);
        botaoListarServico.setBounds(210, 190, 190, 25);

        botaoListarPagamento.setText("Listar por pagamento");
        botaoListarPagamento.addActionListener(this::botaoListarPagamentoActionPerformed);
        getContentPane().add(botaoListarPagamento);
        botaoListarPagamento.setBounds(410, 190, 190, 25);

        // ---------- busca pelo ID ----------
        jLabel3.setText("ID do cliente:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 235, 100, 20);

        getContentPane().add(IdBusca);
        IdBusca.setBounds(120, 235, 80, 25);

        botaoBuscar.setText("Buscar");
        botaoBuscar.addActionListener(this::botaoBuscarActionPerformed);
        getContentPane().add(botaoBuscar);
        botaoBuscar.setBounds(210, 235, 90, 25);

        // ---------- campos para alterar ----------
        jLabel4.setText("Nome:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 275, 100, 20);
        getContentPane().add(Nome);
        Nome.setBounds(120, 275, 180, 25);

        jLabel5.setText("Contato:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 310, 100, 20);
        getContentPane().add(Contato);
        Contato.setBounds(120, 310, 180, 25);

        jLabel6.setText("Marca/modelo:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 345, 100, 20);
        getContentPane().add(Marca);
        Marca.setBounds(120, 345, 180, 25);

        jLabel7.setText("Ano:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 380, 100, 20);
        getContentPane().add(Ano);
        Ano.setBounds(120, 380, 180, 25);

        jLabel8.setText("Serviço:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(330, 240, 100, 20);

        listaServico.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Pintura", "Polimento", "Avaliação completa", "troca de oleo", "Motor" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaServico);
        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(330, 265, 160, 100);

        jLabel9.setText("Pagamento:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(330, 370, 100, 20);

        listaPagamento.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Dinheiro", "Pix", "Cartão", "Crédito" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listaPagamento);
        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(330, 395, 160, 70);

        // ---------- botões ----------
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(this::botaoAtualizarActionPerformed);
        getContentPane().add(botaoAtualizar);
        botaoAtualizar.setBounds(20, 425, 120, 30);

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(this::botaoExcluirActionPerformed);
        getContentPane().add(botaoExcluir);
        botaoExcluir.setBounds(160, 425, 120, 30);

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(this::botaoVoltarActionPerformed);
        getContentPane().add(botaoVoltar);
        botaoVoltar.setBounds(510, 435, 90, 30);

        setSize(630, 525);
        setLocationRelativeTo(null);
    }

    // ==================== READ ====================
    // Coloca cada registro como item das duas listas.
    // As listas só mudam quando uma das 3 consultas é feita.
    private void mostrarLista(List<String[]> dados) {
        modeloClientes.clear();
        modeloServicos.clear();
        registros = dados;

        for (String[] r : registros) {
            // r = {id, nome, contato, marca, ano, servico, pagamento}
            modeloClientes.addElement(r[0] + " - " + r[1] + " - " + r[2]);
            modeloServicos.addElement(r[3] + " " + r[4] + " - " + r[5] + " - " + r[6]);
        }

        IdBusca.setText("");
        Nome.setText("");
        Contato.setText("");
        Marca.setText("");
        Ano.setText("");

        if (registros.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Nenhum registro encontrado!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Listagem 1: todos
    private void botaoListarTodosActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarLista(op.listar());
    }

    // Listagem 2: filtra pelo serviço marcado na lista "Serviço"
    private void botaoListarServicoActionPerformed(java.awt.event.ActionEvent evt) {
        String servico = listaServico.getSelectedValue();
        if (servico == null) {
            JOptionPane.showMessageDialog(null,
                    "Selecione um serviço na lista de Serviço!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            mostrarLista(op.listarPorServico(servico));
        }
    }

    // Listagem 3: filtra pela forma de pagamento marcada na lista "Pagamento"
    private void botaoListarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {
        String pagamento = listaPagamento.getSelectedValue();
        if (pagamento == null) {
            JOptionPane.showMessageDialog(null,
                    "Selecione uma forma de pagamento na lista de Pagamento!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            mostrarLista(op.listarPorPagamento(pagamento));
        }
    }

    private void limparCampos() {
        IdBusca.setText("");
        Nome.setText("");
        Contato.setText("");
        Marca.setText("");
        Ano.setText("");
        listaServico.clearSelection();
        listaPagamento.clearSelection();
    }

    // Coloca os dados de um registro nos campos
    private void preencherCampos(String[] r) {
        IdBusca.setText(r[0]);
        Nome.setText(r[1]);
        Contato.setText(r[2]);
        Marca.setText(r[3]);
        Ano.setText(r[4]);
        listaServico.setSelectedValue(r[5], true);
        listaPagamento.setSelectedValue(r[6], true);
    }

    // Clicou num cliente: seleciona o mesmo item na outra lista e preenche os campos
    private void ListadeClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {
        int i = ListadeClientes.getSelectedIndex();
        if (i >= 0 && !evt.getValueIsAdjusting()) {
            ListadeServicos.setSelectedIndex(i);
            preencherCampos(registros.get(i));
        }
    }

    // Clicou num serviço: seleciona o mesmo item na lista de clientes
    private void ListadeServicosValueChanged(javax.swing.event.ListSelectionEvent evt) {
        int i = ListadeServicos.getSelectedIndex();
        if (i >= 0 && !evt.getValueIsAdjusting()) {
            ListadeClientes.setSelectedIndex(i);
        }
    }

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = Integer.parseInt(IdBusca.getText());
            String[] r = op.buscarPorId(id);

            if (r == null) {
                JOptionPane.showMessageDialog(null,
                        "Nenhum cliente com esse ID!",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                preencherCampos(r);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Digite um ID válido (número)!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ==================== UPDATE ====================
    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        if (IdBusca.getText().isEmpty() || Nome.getText().isEmpty() || Contato.getText().isEmpty()
                || Marca.getText().isEmpty() || Ano.getText().isEmpty()
                || listaServico.getSelectedValue() == null
                || listaPagamento.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null,
                    "Preencha todos os dados!!!",
                    "Aviso!!!",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(IdBusca.getText());
            int ano = Integer.parseInt(Ano.getText());

            boolean ok = op.atualizar(id, Nome.getText(), Contato.getText(),
                    Marca.getText(), ano,
                    listaServico.getSelectedValue(), listaPagamento.getSelectedValue());

            if (ok) {
                JOptionPane.showMessageDialog(null,
                        "Dados atualizados com sucesso!\nFaça uma nova consulta para ver a lista atualizada.",
                        "Operação bem sucedida",
                        JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Não foi possível atualizar (verifique o ID)",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "ID e Ano precisam ser números!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ==================== DELETE ====================
    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (IdBusca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Selecione um cliente ou informe o ID!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int resp = JOptionPane.showConfirmDialog(null,
                "Deseja realmente excluir o cliente " + IdBusca.getText() + "?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(IdBusca.getText());

                if (op.deletar(id)) {
                    JOptionPane.showMessageDialog(null,
                            "Registro excluído com sucesso!\nFaça uma nova consulta para ver a lista atualizada.",
                            "Operação bem sucedida",
                            JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Não foi possível excluir (verifique o ID)",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Digite um ID válido (número)!",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaUpdate().setVisible(true));
    }

    private javax.swing.JTextField Ano;
    private javax.swing.JTextField Contato;
    private javax.swing.JTextField IdBusca;
    private javax.swing.JList<String> ListadeClientes;
    private javax.swing.JList<String> ListadeServicos;
    private javax.swing.JTextField Marca;
    private javax.swing.JTextField Nome;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoListarPagamento;
    private javax.swing.JButton botaoListarServico;
    private javax.swing.JButton botaoListarTodos;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listaPagamento;
    private javax.swing.JList<String> listaServico;
}
