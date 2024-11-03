package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.view.ErrorMessages.DUPLICATION_LOTTO_NUMBER;
import static lotto.view.ErrorMessages.INVALID_LOTTO_NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public Rank calculateRank(List<Integer> winningLottoNumbers, int bonusNumber) {
        int basicCount = 0;
        int bonusCount = 0;
        for (int winningLottoNumber : winningLottoNumbers) {
            if (numbers.contains(winningLottoNumber)) {
                basicCount++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            bonusCount++;
        }

        return Rank.calculateRank(basicCount, bonusCount);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_MAX_NUMBER.getUnit()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() < LOTTO_MAX_NUMBER.getUnit()) {
            throw new IllegalArgumentException(DUPLICATION_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
