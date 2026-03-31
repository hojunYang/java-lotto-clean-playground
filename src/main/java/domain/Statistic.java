package domain;

import java.util.ArrayList;
import java.util.List;

public class Statistic {

    public static final int WINNING_COUNT = 1;
    public static final int MATCHED_THREE_PRIZE = 5000;
    public static final int MATCHED_FOUR_PRIZE = 50000;
    public static final int MATCHED_FIVE_PRIZE = 1500000;
    public static final int MATCHED_SIX_PRIZE = 2000000000;
    public static final int MATCHED_TRHEE_COUNT = 3;
    public static final int MATHCED_FOUR_COUNT = 4;
    public static final int MATCHED_FIVE_COUNT = 5;
    public static final int MATCHED_SIX_COUNT = 6;

    public List<Integer> getWinningResult(List<LottoTicket> lottoTickets, List<Integer> winningNumbers) {
        List<Integer> winningResult = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0));
        for(LottoTicket lottoTicket: lottoTickets) {
            int index = lottoTicket.getMatchedNumbers(winningNumbers);
            winningResult.set(index, winningResult.get(index) + WINNING_COUNT);
        }
        return winningResult;
    }

    public double getRevenue(int money, List<Integer> winningResult){
        double prize = MATCHED_THREE_PRIZE * winningResult.get(MATCHED_TRHEE_COUNT)
                     + MATCHED_FOUR_PRIZE  * winningResult.get(MATHCED_FOUR_COUNT)
                     + MATCHED_FIVE_PRIZE  * winningResult.get(MATCHED_FIVE_COUNT)
                     + MATCHED_SIX_PRIZE   * winningResult.get(MATCHED_SIX_COUNT);
        return prize/money;
    }
}
