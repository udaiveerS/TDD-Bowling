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
                score += 10 + nextBallForSpare(frameRoll);
            } else if(isStrike(frameRoll)) {
                score += 10 + nextTwoBallsForStrike(frameRoll);
            } else {
                score += twoBallsInFrame(frameRoll);
            }
        }

        return score;
    }

    private int twoBallsInFrame(int frameRoll) {
        return frames[frameRoll] + frames[frameRoll+1];
    }

    private int nextTwoBallsForStrike(int frameRoll) {
        return frames[frameRoll + 1] + frames[frameRoll + 2];
    }

    private int nextBallForSpare(int frameRoll) {
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
