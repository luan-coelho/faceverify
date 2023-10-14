package br.com.luan.service;

import br.com.luan.model.Event;
import br.com.luan.repository.EventRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventService extends BaseService<Event, Long, EventRepository> {

}
