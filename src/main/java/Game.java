public class Game {

    private int[] frames;

    private int currentFrame;

    public Game() {
        frames = new int[21];
        currentFrame = 0;
    }

    public int score() {
        int score = 0;

        for(int frameRoll = 0; frameRoll < 19; frameRoll += 2) {
            // spare
            if(isSpare(frameRoll)) {
                score += 10 + getNextRoll(frameRoll);
            } else if(isStrike(frameRoll)) {
                score += 10 + getNextTwoFrameRolls(frameRoll);
            } else {
                score += getCurrentTwoFrameRolls(frameRoll);
            }
        }

        return score;
    }

    private int getCurrentTwoFrameRolls(int frameRoll) {
        return frames[frameRoll] + frames[frameRoll+1];
    }

    private int getNextTwoFrameRolls(int frameRoll) {
        return frames[frameRoll + 1] + frames[frameRoll + 2];
    }

    private int getNextRoll(int frameRoll) {
        return frames[frameRoll+2];
    }

    private boolean isStrike(int frameRoll) {
        return frames[frameRoll] == 10;
    }

    private boolean isSpare(int frameRoll) {
        return frames[frameRoll] + frames[frameRoll+1] == 10;
    }

    public void roll(int pinsRolled) {
        frames[currentFrame++] = pinsRolled;
    }
}
