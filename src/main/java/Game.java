public class Game {

    private int[] frames;

    private int currentFrame;

    public Game() {
        frames = new int[21];
        currentFrame = 0;
    }

    public int score() {
        int score = 0;

        for(int rollIndex = 0; rollIndex < 19; rollIndex += 2) {
            // spare
            if(isSpare(rollIndex)) {
                score += 10 + frames[rollIndex+2];
            } else if(isStrike(frames[rollIndex])) {
                score += 10 + frames[rollIndex+1] + frames[rollIndex+2];
            } else {
                score += frames[rollIndex] + frames[rollIndex+1];
            }
        }

        return score;
    }

    private boolean isStrike(int frame) {
        return frame == 10;
    }

    private boolean isSpare(int rollIndex) {
        return frames[rollIndex] + frames[rollIndex+1] == 10;
    }

    public void roll(int pinsRolled) {
        frames[currentFrame++] = pinsRolled;
    }
}
