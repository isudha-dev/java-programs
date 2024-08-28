package concepts.comparable_comparator;

public class Song implements Comparable<Song>{
    String title;
    String writer;
    String singer;
    private Integer score;

    public Song(final String title, final String writer, final String singer, final int score) {
        this.title = title;
        this.writer = writer;
        this.singer = singer;
        this.score = score;
    }

    @Override
    public int compareTo(final Song o) {
        return this.score - o.score;
    }

    @Override public String toString() {
        return "Song1{" +
            "title='" + title + '\'' +
            ", writer='" + writer + '\'' +
            ", singer='" + singer + '\'' +
            ", score=" + score +
            '}';
    }
}
