package controller;

import domain.LottoNumber;
import domain.LottoService;
import domain.LottoTicket;
import domain.Statistic;
import domain.WinningResultDto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final Statistic statistic;

    public Controller(InputView inputView, OutputView outputView,
                      LottoService lottoService, Statistic statistic) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.statistic = statistic;
    }

    public void run(){
        int money = inputView.getMoney();

        List<LottoTicket> lottoTickets = lottoService.buyTickets(money);

        outputView.printLottoList(lottoTickets.size(), lottoTickets);

        List<Integer> winningNumbers = inputView.getWinningNumbers();

        LottoTicket winningTicket = new LottoTicket(
                winningNumbers.stream()
                        .map(LottoNumber::new)
                        .toList()
        );

        WinningResultDto winningResult = statistic.getWinningResult(lottoTickets, winningTicket);
        double revenue = statistic.getRevenue(money, winningResult);

        outputView.printResult(winningResult, revenue);
    }
}
