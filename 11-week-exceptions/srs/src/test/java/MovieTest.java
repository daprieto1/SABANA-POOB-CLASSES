import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MovieTest {

    @Test
    @DisplayName("When Collections Sort")
    public void shouldPrintMoviesInOrderUsingCollectionsSort() {

        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Lord Of The Rings", 10, 2003));
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);

        System.out.println("Movies after sorting : ");
        for (Movie movie : list) {
            System.out.println(movie);
        }

    }

    @Test
    @DisplayName("When Priority Queue")
    public void shouldKeepMoviesInOrderUsingPriorityQueue() {

        Queue<Movie> queue = new PriorityQueue<>();
        queue.add(new Movie("Lord Of The Rings", 10, 2003));
        queue.add(new Movie("Force Awakens", 8.3, 2015));
        queue.add(new Movie("Star Wars", 8.7, 1977));
        queue.add(new Movie("Empire Strikes Back", 8.8, 1980));
        queue.add(new Movie("Return of the Jedi", 8.4, 1983));

        System.out.println("Movies keeping order: ");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
