function solution(s) {
  return s.split('').sort().reverse().join('');
}

test('sample', () => {
  expect(solution('Zbcdefg')).toBe('gfedcbZ');
});
