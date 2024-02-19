import { TestBed } from '@angular/core/testing';

import { UserListLinkService } from './user-list-link.service';

describe('UserListLinkService', () => {
  let service: UserListLinkService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserListLinkService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
