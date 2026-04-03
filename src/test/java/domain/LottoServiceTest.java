package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;
import util.SequenceGenerator;

import java.util.List;


class LottoServiceTest {

    @DisplayName("로또 만들기 테스트")
    @Test
    public void testMakingLotto() {
        //given
        List<Integer> sequence = List.of(1, 5, 3, 2, 6, 7);
        NumberGenerator numberGenerator = new SequenceGenerator(sequence);
        LottoService lottoService = new LottoService(numberGenerator);

        //when
        List<LottoTicket> tickets = lottoService.buyTickets(1000);

        //then
        assertThat(tickets.get(0).getTicketNumbers()).isEqualTo(List.of(1, 5, 3, 2, 6, 7));

    }

}
