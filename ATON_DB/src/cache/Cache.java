package cache;

import record.Record;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Cache {
    private HashMap<Long, List<Node>> table;

    private class Node
    {
        Record data;
        Node next;

        public Node(Record data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public Cache()
    {
        this.table = new HashMap<Long, List<Node>>();
    }

    public void add(Record record)
    {
        long account = record.getAccount();
        Node node = new Node(record);
        List <Node> nodeList;
        if (table.containsKey(account))
        {
            System.out.println("Same account already exist in cache\n");
            return;
        }
        else
        {
            nodeList = new LinkedList<Node>();
            table.put(account, nodeList);
        }
        nodeList.add(node);
    }

    public void remove(long account)
    {
        if (table.remove(account) == null)
            System.out.println("Cannot remove\n");
        else
            System.out.println("Record " + account + " removed\n");
    }

    public void update(long account, String name, double value)
    {
        if (table.containsKey(account))
        {
            List<Node> nodeList = table.get(account);
            for (Node node : nodeList)
                if (node.data.getAccount() == account)
                {
                    node.data.setName(name);
                    node.data.setValue(value);
                    System.out.println("Record " + account + " updated\n");
                    return;
                }
        }
        else
            System.out.println("This account doesn't exist in cache\n");
    }

    public void get_by_Account(long account)
    {
        if (table.containsKey(account))
        {
            List<Node> nodeList = table.get(account);
            for (Node node : nodeList)
                System.out.println(node.data);
        }
        else
            System.out.println("This account doesn't exist in cache\n");
    }

    public void get_by_Name(String name)
    {
        boolean flag = false;
        for (List<Node> nodeList : table.values())
            for (Node node : nodeList)
                if (node.data.getName().equals(name))
                {
                    System.out.println(node.data);
                    flag = true;
                }
        if (!flag)
            System.out.println("This name doesn't exist in cache\n");
    }

    public void get_by_Value(double value)
    {
        boolean flag = false;
        for (List<Node> nodeList : table.values())
            for (Node node : nodeList)
                if (node.data.getValue() == value)
                {
                    System.out.println(node.data);
                    flag = true;
                }
        if (!flag)
            System.out.println("This value doesn't exist in cache\n");
    }

    public void show_AllRecords()
    {
        for (List<Node> nodeList : table.values())
            for (Node node : nodeList)
                System.out.println(node.data);
    }
}
