describe('Merkle home page', () => {
  it('loads and shows the hello component', () => {
    cy.visit('/content/merkle.html');
    cy.get('.cmp-helloworld').should('exist');
  });
});
