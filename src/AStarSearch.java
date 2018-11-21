import java.util.*;

public class AStarSearch   extends ASearch{
	// Define lists here ...

	PriorityQueue<ASearchNode> openList;
	HashMap<String,ASearchNode> closedList;

	@Override
	public String getSolverName()
	{
		return "AStar";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState) {
		HeuristicSearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists() {
		Comparator<ASearchNode> comparator = new fValueComparator();
		openList = new PriorityQueue<>(1000,comparator);
		closedList = new HashMap(1000);
	}

	@Override
	public ASearchNode getOpen(	ASearchNode node) {
		if(isOpen(node)) {
			return node;
		}
		return null;
	}

	@Override
	public boolean isOpen(	ASearchNode node) {
		return openList.contains(node);
	}

	@Override
	public boolean isClosed(ASearchNode node) 	{

		return closedList.containsKey(node._currentProblemState.toString());
	}

	@Override
	public void addToOpen(	ASearchNode node) {
		openList.add(node);
	}

	@Override
	public void addToClosed	(ASearchNode node) {
		closedList.put(node._currentProblemState.toString(),node);
	}

	@Override
	public int openSize(){
		return openList.size();
	}

	@Override
	public ASearchNode getBest() {
		ASearchNode  best = openList.poll();
		return best;
	}

	class fValueComparator implements Comparator<ASearchNode>{
		@Override
		public int compare(ASearchNode x, ASearchNode y){

			if (x.getF() < y.getF()){
				return -1;
			}
			if (x.getF() > y.getF()){
				return 1;
			}
			if (x.getH() < y.getH()){
				return -1;
			}
			if (x.getH() > y.getH()){
				return 1;
			}
			return 1;
		}
	}


}
