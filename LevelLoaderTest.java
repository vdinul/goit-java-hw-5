public class Level {
    private int width;
    private int height;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class LevelTooBigException extends Exception {
    @Override
    public String toString() {
        return "Level too big";
    }
    LevelTooBigException() {
    }
}

class LevelLoader {
    public void load(Level level) throws LevelTooBigException {
        int h = level.getHeight();
        int w = level.getWidth();
        int area = h * w;
        if(area > 100000)
                throw new LevelTooBigException();
        else
            System.out.println("Level loaded");
        }
}

class LevelLoaderTest {
    public static void main(String[] args) {
        //Level loaded
        try {
            new LevelLoader().load(new Level(1000, 200));
        } catch (LevelTooBigException ex) {
            System.out.println(ex);
        }
    }
}