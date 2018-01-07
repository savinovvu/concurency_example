package main.java.ru.inbox.savinov_vu.b_basicSynchronization.producer_consumer_lock;

public class FileMock {
    private String[] content;
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int randomCharacter = (int) Math.random() * 255;
                builder.append((char) randomCharacter);
            }
            content[i] = builder.toString();
        }
        index = 0;
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.println("Mock:" + (content.length-index));
            return content[index++];
        }
        return null;
    }
}
