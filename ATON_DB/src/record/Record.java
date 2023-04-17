package record;

public class Record {
        private long account;
        private String name;
        private double value;

        public Record(long account, String name, double value)
        {
            this.account = account;
            this.name = name;
            this.value = value;
        }

        public long getAccount()
        {
            return account;
        }

        public String getName()
        {
            return name;
        }

        public double getValue()
        {
            return value;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public void setValue(double value)
        {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Record {account=" + account + ", name=" + name + ", value=" + value + "}";
        }
}
