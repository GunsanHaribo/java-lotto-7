package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsDto {
    private final List<LottoDto> lottoTickets;

    public LottoTicketsDto(LottoTickets lottoTickets) {
        this.lottoTickets = getLottoTickets(lottoTickets);
    }

    public LottoTicketsDto(List<List<Integer>> lottoTickets) {
        this.lottoTickets = createLottoTicketsDto(lottoTickets);
    }

    public List<LottoDto> createLottoTicketsDto(List<List<Integer>> lottoTickets) {
        List<LottoDto> lottoTicketDto = new ArrayList<>();
        for (List<Integer> lottoTicket : lottoTickets) {
            lottoTicketDto.add(new LottoDto(lottoTicket));
        }

        return lottoTicketDto;
    }

    private List<LottoDto> getLottoTickets(LottoTickets lottoTickets) {
        List<LottoDto> lottoTicketDto = new ArrayList<>();

        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            lottoTicketDto.add(new LottoDto(lottoTicket.getNumbers()));
        }

        return lottoTicketDto;
    }

    public List<LottoDto> getLottoTickets() {
        return lottoTickets;
    }
}
