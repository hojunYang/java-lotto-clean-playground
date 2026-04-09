package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_SIZE = 6;
    List<LottoNumber> lottoNumbers;

    public LottoTicket (List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::value))
                .toList();
    }

    public String toDisplayString() {
        return lottoNumbers.toString();
    }

    public int getMatchedNumbers(LottoTicket winningTicket) {
        int count = 0;
        for (LottoNumber lottoNumber : winningTicket.lottoNumbers) {
            if (lottoNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
