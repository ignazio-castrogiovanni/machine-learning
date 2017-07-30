import { FagginPage } from './app.po';

describe('faggin App', function() {
  let page: FagginPage;

  beforeEach(() => {
    page = new FagginPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
