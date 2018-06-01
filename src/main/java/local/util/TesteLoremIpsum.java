package local.util;

import de.svenjacobs.loremipsum.LoremIpsum;

import java.util.Random;

public class TesteLoremIpsum {
    public static void main(String[] args) {
        LoremIpsum x = new LoremIpsum();
        System.out.println(x.getWords(1,new Random().nextInt(50)));
    }
}
