package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePrint {

    public static <T extends Comparable<?>> void printNode(Entry<T> root) {
        int maxLevel = TreePrint.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Entry<T>> entries, int level, int maxLevel) {
        if (entries.isEmpty() || TreePrint.isAllElementsNull(entries))
            return;

        int floor = maxLevel - level;
        int lines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        TreePrint.printWhitespaces(firstSpaces);

        List<Entry<T>> newEntries = new ArrayList<>();
        for (Entry<T> entry : entries) {
            if (entry != null) {
                System.out.print(entry.value);
                newEntries.add(entry.left);
                newEntries.add(entry.right);
            } else {
                newEntries.add(null);
                newEntries.add(null);
                System.out.print(" ");
            }

            TreePrint.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= lines; i++) {
            for (Entry<T> entry : entries) {
                TreePrint.printWhitespaces(firstSpaces - i);
                if (entry == null) {
                    TreePrint.printWhitespaces(lines + lines + i + 1);
                    continue;
                }

                if (entry.left != null)
                    System.out.print("/");
                else
                    TreePrint.printWhitespaces(1);

                TreePrint.printWhitespaces(i + i - 1);

                if (entry.right != null)
                    System.out.print("\\");
                else
                    TreePrint.printWhitespaces(1);

                TreePrint.printWhitespaces(lines + lines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newEntries, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Entry<T> entry) {
        if (entry == null)
            return 0;

        return Math.max(TreePrint.maxLevel(entry.left), TreePrint.maxLevel(entry.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}