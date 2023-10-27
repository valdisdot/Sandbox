package com.valdisdot.sandbox.swing;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;

public class AutocompleteTest {
    /*
    * preload Set<String> getAllKeywords()
    * * add method keywordInsertListener -> service.addKeywordInsertionListener(Consumer<String> updateConsumer): void
    * trigger: action -> input into JComboBox<String>, adding a character
    * * add method getKeywordsLike(String keyword): Set<String>
    * update JComboBox elements
    * */

    public static void main(String[] args) {
        JComboBox<String> stringJComboBox = new JComboBox<>(new String[]{"value1", "test", "hello", "+380958776565", "06685337492"});
        AutoCompleteDecorator.decorate(stringJComboBox);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 100));
        panel.add(stringJComboBox);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
