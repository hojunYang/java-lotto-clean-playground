package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;
import util.SequenceGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticTest {
    @DisplayName("로또 결과 채점 테스트")
    @Test
    public void testWinningResult() {
        //given
        List<Integer> sequence = List.of(1, 5, 3, 2, 6, 7, 11, 12, 13, 14, 15, 16);

        NumberGenerator numberGenerator = new SequenceGenerator(sequence);
        LottoService lottoService = new LottoService(numberGenerator);
        Statistic statistic = new Statistic();
        List<Integer> winningResult = List.of(0,0,0,2,0,0,0);
        //when
        List<LottoTicket> tickets = lottoService.buyTickets(2000);

        //then
        assertThat(statistic.getWinningResult(tickets, List.of(1, 5, 3, 11, 12, 13))).isEqualTo(winningResult);

    }

}
