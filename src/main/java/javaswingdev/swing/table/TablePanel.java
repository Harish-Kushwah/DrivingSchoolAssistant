
package javaswingdev.swing.table;

import java.awt.Dimension;
import javaswingdev.swing.RoundPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author haris
 */
public class TablePanel extends RoundPanel{
    
    private int MAX_COL = 10;
    private String columns[] = new String[MAX_COL];
    private Table table = new Table();

        
    public void setColumnNames(String col[])
    {
        this.columns = col;
    }
    public void addRow(Object row[])
    {
        this.table.addRow(row);
    }
    public void setRowHeight(int height)
    {
        this.table.setRowHeight(height);
    }
    
    
    public TablePanel(String columns[])
    {
        setRound(10);
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane sp = new JScrollPane();

         table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            columns
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        sp.setViewportView(table);        
        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(this);
        this.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
       
        table.fixTable(sp);
//        table.setPreferredSize(new Dimension(1,300));

    }
}
