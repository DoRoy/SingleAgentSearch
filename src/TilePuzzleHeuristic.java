
public class TilePuzzleHeuristic implements IHeuristic
{
	int[][] goalStates3 = {{2,2},
							{0,0},{0,1},{0,2},
							{1,0},{1,1},{1,2},
							{2,0},{2,1}};

	int[][] goalStates4 = {{3,3},
							{0,0},{0,1},{0,2},{0,3},
							{1,0},{1,1},{1,2},{1,3},
							{2,0},{2,1},{2,2},{2,3},
							{3,0},{3,1},{3,2}};
	@Override
	public double getHeuristic(	IProblemState problemState) {

		if (problemState instanceof  TilePuzzleState){
			TilePuzzleState myState = (TilePuzzleState) problemState;

			int tileSize = myState._tilePuzzle.length;
			int[][] puzzleArr = myState._tilePuzzle;

			int h = 0;
			int[][] currnentGoalState = null;
			if (tileSize == 3) {
				currnentGoalState = goalStates3;
			}else if (tileSize == 4) {
				currnentGoalState = goalStates4;
			}

			for (int i = 0; i < tileSize; i ++){
				for (int j = 0; j < tileSize; j++){
					h += (Math.abs(i - currnentGoalState[puzzleArr[i][j]][0]) + Math.abs(j - currnentGoalState[puzzleArr[i][j]][1])) * puzzleArr[i][j];
				}
			}
			return h;
		}
		return 0;
	}
	
}
