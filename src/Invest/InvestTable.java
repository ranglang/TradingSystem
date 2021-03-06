/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Invest;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Aioros
 */
public class InvestTable extends javax.swing.JDialog {

    /**
     * Creates new form InvestTable
     *
     * @param parent
     * @param modal
     */
    public InvestTable(java.awt.Frame parent, boolean modal, Strategy stg) {
        super(parent, modal);
        initComponents();

        strategy = stg;
        int times = strategy.recordDataList.size();
        String[][] tableContent = new String[times][10];
        for (int i = 0; i < times; i++) {
            tableContent[i][0] = strategy.recordDataList.get(i).date;
            tableContent[i][1] = strategy.recordDataList.get(i).type;
            tableContent[i][2] = "" + strategy.recordDataList.get(i).price;
            tableContent[i][3] = String.format("%.5f", strategy.recordDataList.get(i).diff);
            tableContent[i][4] = String.format("%.2f", strategy.recordDataList.get(i).input);
            tableContent[i][5] = String.format("%.3f", strategy.recordDataList.get(i).number);
            tableContent[i][6] = String.format("%.3f", strategy.recordDataList.get(i).cost);
            tableContent[i][7] = String.format("%.2f", strategy.recordDataList.get(i).totalInput);
            tableContent[i][8] = String.format("%.2f", strategy.recordDataList.get(i).profit);
            tableContent[i][9] = String.format("%.3f%%", strategy.recordDataList.get(i).profitRatio);
        }
        jTableInvest.getTableHeader().setFont(new java.awt.Font("微软雅黑", 0, 13));
        jTableInvest.setModel(new javax.swing.table.DefaultTableModel(
                tableContent,
                new String[]{
                    "投资日期", "类型", "价格", "离差", "投资额", "数量", "成本价", "总投入", "总利润", "利润率"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableInvest.setRowHeight(20);
        jScrollPaneInvest.setViewportView(jTableInvest);
        if (jTableInvest.getColumnModel().getColumnCount() > 0) {
            jTableInvest.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableInvest.getColumnModel().getColumn(1).setPreferredWidth(42);
            jTableInvest.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableInvest.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableInvest.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTableInvest.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        setTableRowColor(jTableInvest, new Color(0, 128, 0), new Color(220, 0, 0));

        setPreferredSize(new java.awt.Dimension(715, 40 * (times < 10 ? times : 10) + 90));
        jScrollPaneInvest.setPreferredSize(new java.awt.Dimension(620, 40 * (times < 10 ? times : 10) + 31));
        getContentPane().add(jScrollPaneInvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, -1));
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public static void setTableRowColor(JTable Table, final Color color1, final Color color2) {
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    String status = (String) Table.getValueAt(row, 1);
                    if (status.equals("投入")) {
                        setForeground(color1);
                    } else if (status.equals("赎回")) {
                        setForeground(color2);
                    } else {
                        setForeground(new Color(0, 0, 220));
                    }
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            };
            for (int i = 0; i < Table.getColumnCount(); i++) {
                Table.getColumnModel().getColumn(i).setCellRenderer(tcr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneInvest = new javax.swing.JScrollPane();
        jTableInvest = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("交易记录");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPaneInvest.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jScrollPaneInvest.setPreferredSize(new java.awt.Dimension(452, 20));

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        jTableInvest.setDefaultRenderer(Object.class, tcr);
        jTableInvest.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableInvest.getTableHeader().setFont(new java.awt.Font("微软雅黑", 0, 12));
        jTableInvest.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTableInvest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "投资日期", "类型", "价格", "离差", "投资额", "数量", "成本价", "总投入", "总利润", "利润率"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInvest.setRowHeight(20);
        jScrollPaneInvest.setViewportView(jTableInvest);
        if (jTableInvest.getColumnModel().getColumnCount() > 0) {
            jTableInvest.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableInvest.getColumnModel().getColumn(1).setPreferredWidth(42);
            jTableInvest.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableInvest.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableInvest.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTableInvest.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        getContentPane().add(jScrollPaneInvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPaneInvest;
    private javax.swing.JTable jTableInvest;
    // End of variables declaration//GEN-END:variables

    private Strategy strategy;
}
