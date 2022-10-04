public class MarkdownProcessor {
    MarkdownString mdString;
    CommandProcessor cmdProcessor;

    public MarkdownProcessor(MarkdownString mdString) {
        this.mdString = mdString;
        cmdProcessor = new CommandProcessor();
    }

    public void markItalic(int start, int end) {
        cmdProcessor.doCommand(new ItalicCommand(mdString, start, end));
    }

    public void markBold(int start, int end) {
        cmdProcessor.doCommand(new BoldCommand(mdString, start, end));
    }

    public void printMarkdown() {
        System.out.println(mdString.text);
    }

    public void undo() {
        cmdProcessor.undoCommand();
    }

    public static void main(String[] args) {
        MarkdownString string = new MarkdownString("Hello World");
        MarkdownProcessor processor = new MarkdownProcessor(string);

        processor.printMarkdown();
        processor.markItalic(0, 4);
        processor.printMarkdown();
        processor.markItalic(8, 12);
        processor.printMarkdown();
        processor.markBold(0, 6);
        processor.printMarkdown();
        processor.markBold(13, 13);
        processor.printMarkdown();
        processor.undo();
        processor.printMarkdown();
        processor.undo();
        processor.printMarkdown();
    }
}
