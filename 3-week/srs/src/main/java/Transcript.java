import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private List<TranscriptEntry> entries;

    public Transcript() {
        this.entries = new ArrayList<>();
    }

    public boolean addTranscriptEntry(Course courseTaken, int grade) {
        TranscriptEntry entry = new TranscriptEntry(courseTaken, grade);
        return this.entries.add(entry);
    }

    public boolean addTranscriptEntry(TranscriptEntry entry) {
        return this.entries.add(entry);
    }

    public double getAverageGrade() {
        double average = 0;

        if (this.entries.size() > 0) {
            for (TranscriptEntry entry : this.entries) {
                average += entry.getGrade();
            }
            average = average / this.entries.size();
        }
        return average;
    }
}
