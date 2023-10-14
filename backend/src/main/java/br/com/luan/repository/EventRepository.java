package br.com.luan.repository;

import br.com.luan.model.Event;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventRepository extends BaseRepository<Event, Long> {

}

