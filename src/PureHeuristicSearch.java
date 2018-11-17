import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PureHeuristicSearch  extends ASearch
{
	// Define lists here ...
	PriorityQueue<ASearchNode> openList;
	HashSet<ASearchNode> closedList;
	
	@Override
	public String getSolverName() 
	{
		return "PHS";
	}

	@Override
	public ASearchNode createSearchRoot	(IProblemState problemState	) {
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() {
		Comparator<ASearchNode> comparator = new fValueComparator();
		openList = new PriorityQueue<>(10,comparator);
		closedList = new HashSet<>();
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
		return closedList.contains(node);
	}

	@Override
	public void addToOpen(	ASearchNode node) {
		openList.add(node);
	}

	@Override
	public void addToClosed	(ASearchNode node) {
		closedList.add(node);
	}

	@Override
	public int openSize()
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest() {
		ASearchNode  best = openList.poll();
		return best;
	}


	class fValueComparator implements Comparator<ASearchNode> {
		@Override
		public int compare(ASearchNode x, ASearchNode y) {

			if (x.getF() < y.getF()) {
				return -1;
			}
			if (x.getF() > y.getF()) {
				return 1;
			}
			return 0;
		}
	}
}