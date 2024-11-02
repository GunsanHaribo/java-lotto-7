package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public Rank calculateLotto(List<Integer> winningLotto, int bonusNumber) {
        int basicCount = 0;
        int bonusCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(winningLotto.get(i))) {
                basicCount++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            bonusCount++;
        }

        return Rank.calculateRank(basicCount, bonusCount);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }
}
